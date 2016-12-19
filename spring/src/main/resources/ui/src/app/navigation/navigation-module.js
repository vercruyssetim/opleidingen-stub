import angular from 'angular';
import menuCtrl from './menu-controller';

const dependencies = [];

export default angular
    .module('ai.ui.navigation', dependencies)
    .controller('MenuCtrl', menuCtrl);
