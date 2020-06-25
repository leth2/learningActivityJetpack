pipeline {
  agent any
  stages {
    stage('permission setting ') {
      steps {
        sh 'chmod +x gradlew'
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
        mattermostSend(message: 'new artifact', endpoint: 'http://localhost:8065/hooks/m4o7f9ex5pdajr145bqoanaihy', failOnError: true)
      }
    }

  }
}