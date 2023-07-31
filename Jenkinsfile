pipeline{
	agent any
	environment {
		DOCKERHUB_PASS = 'Gmason@2023'
	}
	stages{
		stage("Building the Student Survey Image"){
			steps{
				script{
					checkout scm
					sh 'rm -rf *.jar'
					sh 'mvn clean package'
					sh 'echo ${BUILD_TIMESTAMP}'
					sh 'docker login -u akhileshm01 -p ${DOCKERHUB_PASS}'
					sh 'docker build -t akhileshm01/myspringbootapp .'
				}
			}
		}
		stage("Pushing image to docker"){
			steps{
				script{
					sh 'docker push akhileshm01/myspringbootapp'
				}
			}
		}
		stage("Deploying to rancher"){
			steps{
				script{
					sh 'kubectl rollout restart deploy swe645assn3deployment'
				}
			}
		}
	}
}