def call ( String Project , String ImageTag, String dockerhub){
  withCredentials([usernamePassword(
                    credentialsId:"dockerhub-credencial",
                    usernameVariable:"dockerHubUser", 
                    passwordVariable:"dockerHubPass")]){
  sh ' docker login -u ${dockerHubUser} -p ${dockerHubPass}'
  }
  sh ' docker push ${dockerHubUser} /${Project}:${ImageTag}'
}
