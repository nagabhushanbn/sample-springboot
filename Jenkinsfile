node {
    checkout scm
    stage('Build') {
        sh './gradlew assemble'
        archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
    }

    stage('Deploy') {
        def jar_name = "demo-1.0.jar"
        sh label: '', script:
        '''     scp ${WORKSPACE}/build/libs/'''+jar_name+''' ciuser@${IP}:/servers
                scp ${WORKSPACE}/script.sh ciuser@${IP}:/servers/
                ssh ciuser@${IP} '/bin/bash /servers/script.sh'

                ssh ciuser@${IP} 'ls /servers'

                ssh ciuser@${IP} 'nohup java -jar /servers/'''+jar_name+''' > output.txt&'
        '''
    }
}
