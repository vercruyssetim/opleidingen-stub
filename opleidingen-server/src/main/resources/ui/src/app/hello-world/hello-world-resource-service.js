class HelloWorldResource{
    constructor($http, ENV){
        this.$http = $http;
        this.ENV = ENV;
        this.HTTP_CONFIG = {
            timeout: ENV.defaulRestTimeoutInMillis
        };
    }

    helloWorld(){
        return this.$http.get(this.ENV.endpoint + '/hello/helloWorld', this.HTTP_CONFIG);
    }
}

HelloWorldResource.$inject = ['$http', 'ENV'];

export default  HelloWorldResource;
