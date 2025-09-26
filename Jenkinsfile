pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/YOUR-USERNAME/flipkart-clone.git'
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                sh '''
                WAR_FILE=target/flipkart-clone.war
                TOMCAT_USER=admin
                TOMCAT_PASS=admin
                TOMCAT_URL=http://your-server-ip:8080/manager/text

                curl -u $TOMCAT_USER:$TOMCAT_PASS                      --upload-file $WAR_FILE                      "$TOMCAT_URL/deploy?path=/flipkart&update=true"
                '''
            }
        }
    }
}