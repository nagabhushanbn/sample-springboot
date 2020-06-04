node {
    checkout scm
    stage('Build') {
        sh './gradlew assemble'
        archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
    }

    stage('Deploy') {
        def jar_name = "demo-1.0.jar"
        sh label: '', script:
        """     scp ${env.WORKSPACE}/build/libs/${jar_name} ciuser@18.212.181.247:/servers
                ssh ciuser@18.212.181.247 \'kill $(ps aux | grep \'java -jar /servers/demo-1.0.jar\'| awk \'{print $2}\')\'
                ssh ciuser@18.212.181.247 \'ls /servers\'

                ssh ciuser@18.212.181.247 \'nohup java -jar /servers/${jar_name} > output.txt&\'
        """
    }
}
