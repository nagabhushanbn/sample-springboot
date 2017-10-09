node {
    checkout scm

    stage('Build') {
        sh './gradlew assemble'
        archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
    }

    stage('Deploy') {
        sh """
        jar_name=demo-1.0.jar
        cp ${env.WORKSPACE}/build/libs/${jar_name} ~/servers
        cd ~/servers
        if [ \$(pgrep -f ${jar_name} | wc -l) -gt 0 ]; then
            pkill -9 -f ${jar_name}
            echo "stop application"
        fi
        BUILD_ID=DONTKILLME nohup java -jar ${jar_name} &
        """
    }
}