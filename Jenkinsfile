pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/Sajithkrishnan3/Selenium.git'
            }
        }

stage('Build') {
    steps {
        sh '''
            echo "JAVA_HOME=$JAVA_HOME"
            which java
            java -version
            which javac
            javac -version
            /opt/homebrew/Cellar/maven/3.9.16/bin/mvn clean test
        '''
    }
}

    post {
        always {
            echo 'Selenium execution completed.'
        }

        success {
            echo 'Selenium tests passed!'
        }

        failure {
            echo 'Selenium tests failed!'
        }
    }
}