pipeline {
    agent any

    stages {

        stage('Build') {
            steps {
                sh '''
                    export JAVA_HOME=$(/usr/libexec/java_home -v 26)
                    export PATH="$JAVA_HOME/bin:/opt/homebrew/Cellar/maven/3.9.16/bin:$PATH"

                    echo "Java version:"
                    java -version

                    echo "Maven version:"
                    mvn -version

                    echo "Running Maven tests:"
                    mvn clean test
                '''
            }
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