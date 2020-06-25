pipeline {
  agent any
  stages {
    stage('permission setting ') {
      parallel {
        stage('permission setting ') {
          steps {
            sh 'chmod +x gradlew'
          }
        }

        stage('send start') {
          steps {
            mattermostSend(endpoint: 'http://192.168.1.210:8065/hooks/m4o7f9ex5pdajr145bqoanaihy', message: 'build start', failOnError: true)
          }
        }

      }
    }

    stage('assembleDebug') {
      steps {
        sh './gradlew --no-daemon assembleDebug --stacktrace'
      }
    }

    stage('archive') {
      steps {
        archiveArtifacts(artifacts: '*/build/**/*.apk', onlyIfSuccessful: true)
      }
    }

    stage('mattamost') {
      steps {
        mattermostSend(message: 'new artifact', endpoint: 'http://192.168.1.210:8065/hooks/m4o7f9ex5pdajr145bqoanaihy', failOnError: true)
      }
    }

  }
}