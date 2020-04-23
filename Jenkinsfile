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

  }
}