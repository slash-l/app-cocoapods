def server
def SERVER_NAME = "saas-server"
def buildInfo
def promotionConfig

node{
    stage("Artifactory config"){
        server = Artifactory.server SERVER_NAME

    }
    
    stage("SCM Check out"){
        git branch: "main", url: 'https://github.com/slash-l/app-cocoapods.git'
    }
    
    stage("Pod install"){
        def pod_install_result = sh returnStatus: true, script: "cd app-swift-demo && pod install"
        echo "pod install result:" + pod_install_result
    }
    
    stage("Pod upload"){
        def pwd = sh returnStatus: true, script: "pwd"
        echo "pwd:" + pwd
        
        def pod_spec_result = sh returnStatus: true, script: "cd app-swift-demo && /usr/local/bin/pod spec create app-swift-demo && cd .. && tar -czvf app-swift-demo.tar.gz app-swift-demo"
        echo "pod spec result:" + pod_spec_result
        
        // upload to Artifactory
        def uploadSpec = """{
          "files": [
            {
              "pattern": "app-swift-demo.tar.gz",
              "target": "slash-cocoapods-dev-local/app-swift-demo/"
            }
         ]
        }"""
        server.upload spec: uploadSpec
    }
    
    stage("Set Props"){
        
    }
    
    stage("Publish Build Info"){
        
    }
    
    stage("Promotion"){
        // promotionConfig = [
        //     //Mandatory parameters
        //     'buildName'          : buildInfo.name,
        //     'buildNumber'        : buildInfo.number,
        //     'targetRepo'         : "slash-cocoapods-test-local",

        //     //Optional parameters
        //     'comment'            : 'this is the promotion comment',
        //     'sourceRepo'         : "slash-cocoapods-dev-local",
        //     'status'             : 'Released',
        //     'includeDependencies': true,
        //     'failFast'           : true,
        //     'copy'               : true
        // ]

        // // Promote build
        // server.promote promotionConfig
    }
}
