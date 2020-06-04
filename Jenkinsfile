node {
    checkout scm

    stage('Build') {
        sh './gradlew assemble'
        archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
    }

    stage('Deploy') {
        def jar_name = "demo-1.0.jar"
        sh """
        scp ${env.WORKSPACE}/build/libs/${jar_name} ciuser@18.212.181.247:/servers

        ssh ciuser@18.212.181.247 'if [ \$(pgrep -f ${jar_name} | wc -l) -gt 0 ]; then
            pkill -9 -f ${jar_name}
        fi'

        ssh ciuser@18.212.181.247 'ls /servers'

        ssh ciuser@18.212.181.247 'JENKINS_NODE_COOKIE=DONTKILLME nohup java -jar /servers/${jar_name} &'
        """
    }
}
