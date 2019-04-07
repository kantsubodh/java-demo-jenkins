node{
    def mvnHome
    def javaHome
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
}