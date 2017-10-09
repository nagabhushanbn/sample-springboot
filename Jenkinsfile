node {
    checkout scm

    stage('Build') {
        sh './gradlew assemble'
        archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
    }

    stage('Deploy') {
        sh """
        cp ${env.WORKSPACE}/build/libs/demo-0.0.1.jar ~/servers
        cd ~/servers
        BUILD_ID=DONTKILLME nohup java -jar demo-0.0.1.jar &
        """
    }
}