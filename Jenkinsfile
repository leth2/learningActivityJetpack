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
        sh './gradlew assembleDebug --stacktrace'
      }
    }

  }
}