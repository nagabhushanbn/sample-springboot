node {
    checkout scm
    stage('Build') {
        sh './gradlew assemble'
        archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
    }

    stage('Deploy') {
        def jar_name = "demo-1.0.jar"
        sh label: '', script:
        '''     scp ${WORKSPACE}/build/libs/'''+jar_name+''' ciuser@18.212.181.247:/servers
                scp ${WORKSPACE}/script.sh ciuser@18.212.181.247:/servers/
                ssh ciuser@18.212.181.247 '/bin/bash /servers/script.sh'

                ssh ciuser@18.212.181.247 'ls /servers'

                ssh ciuser@18.212.181.247 'nohup java -jar /servers/'''+jar_name+''' > output.txt&'
        '''
    }
}
