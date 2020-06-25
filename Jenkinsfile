pipeline {
  agent any
  stages {
    stage('permission setting ') {
      parallel {
        stage('permission setting ') {
          steps {
            sh '''chmod +x gradlew
'''
          }
        }

        stage('echo') {
          steps {
            sh '''echo "BUILD_NUMBER" :: $BUILD_NUMBER
echo "BUILD_ID" :: $BUILD_ID
echo "BUILD_DISPLAY_NAME" :: $BUILD_DISPLAY_NAME
echo "JOB_NAME" :: $JOB_NAME
echo "JOB_BASE_NAME" :: $JOB_BASE_NAME
echo "BUILD_TAG" :: $BUILD_TAG
echo "EXECUTOR_NUMBER" :: $EXECUTOR_NUMBER
echo "NODE_NAME" :: $NODE_NAME
echo "NODE_LABELS" :: $NODE_LABELS
echo "WORKSPACE" :: $WORKSPACE
echo "JENKINS_HOME" :: $JENKINS_HOME
echo "JENKINS_URL" :: $JENKINS_URL
echo "BUILD_URL" ::$BUILD_URL
echo "JOB_URL" :: $JOB_URL'''
            mattermostSend '"Build STARTED: ${env.JOB_NAME} #${env.BUILD_NUMBER} (<${env.BUILD_URL}|Link to build>)"'
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
        mattermostSend(message: 'Build SUCCESS: ${JOB_NAME} #${BUILD_NUMBER} (<${BUILD_URL}|Link to build>)', endpoint: 'http://leth2.asuscomm.com:7778/hooks/m4o7f9ex5pdajr145bqoanaihy', failOnError: true, channel: 'test')
      }
    }

  }
}