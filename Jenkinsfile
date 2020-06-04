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
        ssh ciuser@18.212.181.247 "cd /servers"
        ssh ciuser@18.212.181.247 "if [ \$(pgrep -f ${jar_name} | wc -l) -gt 0 ]; then
            pkill -9 -f ${jar_name}
            echo "stop application"
        fi"
        ssh ciuser@18.212.181.247 "nohup java -jar ${jar_name} &"
        """
    }
}
