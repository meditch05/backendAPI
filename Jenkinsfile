//===============================================================================================
// 변수처리 하려면 명령어를 "" 로 묶어야 한다. ''로 묶으면 PlainText 처리해버림
// [ Jenkins Parameter ]
// 01 - GIT_CREDENTIAL ( GitLab ID/PWD ) 
//===============================================================================================

def git_url       = "http://gitlab-ce.infra.svc/p069528/csp_nateonbiz.git"
def docker_repo   = "myregistry.mwportal.com:30001/cspapi/nateonbiz"
def docker_ver    = "1.0"
def namespace     = "cspapi"
def app           = "csp-nateonbiz"

def image_tag     = "${docker_repo}:${docker_ver}"
def label         = "jenkins-slave-jnlp-${UUID.randomUUID().toString()}"

podTemplate(label: label, cloud: 'kubernetes', serviceAccount: 'jenkins', nodeSelector: 'kubernetes.io/hostname=skt-elkpap02',
	containers: [
		containerTemplate(name: 'jnlp', image: 'jenkins/jnlp-slave:3.27-1', args: '${computer.jnlpmac} ${computer.name}',
			envVars: [
				envVar(key: 'JVM_HEAP_MIN', value: '-Xmx192m'),
				envVar(key: 'JVM_HEAP_MAX', value: '-Xmx192m')
			]
		),
		containerTemplate(name: 'maven',    image: 'maven:3.6.1-jdk-8-alpine',                  ttyEnabled: true, command: 'cat'),
		containerTemplate(name: 'docker',   image: 'docker:18.06',                      ttyEnabled: true, command: 'cat', resourceLimitMemory: '128Mi'),
		containerTemplate(name: 'kubectl',  image: 'lachlanevenson/k8s-kubectl:latest', ttyEnabled: true, command: 'cat', resourceLimitMemory: '256Mi')
	],
	volumes:[
		hostPathVolume(mountPath: '/var/run/docker.sock',   hostPath: '/var/run/docker.sock'),
		hostPathVolume(mountPath: '/etc/hosts',             hostPath: '/etc/hosts'),
		persistentVolumeClaim(mountPath: '/home/jenkins/agent/workspace', claimName: 'jenkins-workspace'),
		persistentVolumeClaim(mountPath: '/root/.m2',                     claimName: 'jenkins-maven-repo')
	])
{
	node(label) {
		stage('CheckOut Source') { // gitLab API Plugin, gitLab Plugin
			git branch: "master", url: "${git_url}", credentialsId: env.GIT_CREDENTIAL
		}
		
		stage('Build Maven') {  // Maven Integration:3.3
			container('maven') {
				sh "mvn -f ./pom.xml -B -DskipTests package" // clean package
				// sh "pwd"
				// sh "df -kP ."				
				// sh "ls -l"
				sh "cp ./target/app-1.0.war ."
			}
		}
		
		stage('Build Docker Image') {
			container('docker') {
				sh "docker build -t ${image_tag} -f ./docker/Dockerfile ."
			}
		}
		
		stage('Push Docker Image') {
			container('docker') {
				sh "docker push ${image_tag}"
			}
		}

		stage('k8s Update Deployment Image = ${image_tag}') {
			container('kubectl') {
				sh "kubectl delete -f ./kubernetes/deployment.yaml"		
				sh "kubectl apply -f  ./kubernetes/deployment.yaml"
				sh "kubectl get deploy,pod -n ${namespace} -l app=${app}"
								
				sh "kubectl apply -f ./kubernetes/service.yaml"  // service.yaml 은 초기 테스트시에 구성해야함 ( 그래야지 ㅡ_ㅡ )
				sh "kubectl apply -f ./kubernetes/ingress.yaml"  // ingress.yaml 은 초기 테스트시에 구성해야함 ( 그래야지 ㅡ_ㅡ )
			}
		}
		
	}
}
