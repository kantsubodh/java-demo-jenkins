node{
    def mvnHome
    def javaHome
    try{
        stage('Preparation'){
            git 'https://github.com/kantsubodh/java-demo-jenkins.git'
            mvnHome = tool 'Maven_3.6'
            javaHome = tool 'jdk-12'
        }
        stage('Build'){
            if(isUnix()){
                sh """
                export JAVA_HOME = ${javaHome}
                echo "JAVA_HOME = ${javaHome}"
                '${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package
                """
            }else{
                bat(/ SET JAVA_HOME = ${javaHome}
                    echo "JAVA_HOME = ${javaHome}"
                    "${mvnHome}bin\mvn" -Dmaven.test.failure.ignore clean package /)
            }
        }
        stage('Test'){
            junit '**/target/surefire-reports/TEST-*.xml'
            archive 'target/*.jar'
        }
        stage('complete'){
            slackSend(color:"#FFFF00", message:"SUCCESS: Job - '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")
        }
    }
    catch(e){
        currentBuild.result = "FAILURE"
        slackSend(color:"#FF0000", message:"FAILED: Job - '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")
        throw e;
    }
}