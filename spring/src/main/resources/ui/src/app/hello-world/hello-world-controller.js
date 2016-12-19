class HelloWorldCtrl{
    constructor(helloWorldResource){
        this.helloWorldResource = helloWorldResource;
        this.helloWorldResource.helloWorld().success((result) => {
            this.hello = result;
        });
    }
}

HelloWorldCtrl.$inject = ['helloWorldResource'];

export default HelloWorldCtrl;
