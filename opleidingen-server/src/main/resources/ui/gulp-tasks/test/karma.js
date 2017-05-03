import gulp from 'gulp';
import karma from "karma";
import {files} from "../config";

export const testUnit = 'test:unit';
export const ciUnit = 'ci:unit';

gulp.task(testUnit, (callback) => {
    // remove 'coverage' directory before each test
    //del.sync(path.test.testReports.coverage);

    // run the karma test
    const server = new karma.Server({
        configFile: files.karmaConf,
        singleRun: true
    }, function () {
        callback();
    });
    server.start();
});

gulp.task(ciUnit, (callback) => {
    // remove 'coverage' directory before each test
    //del.sync(path.test.testReports.coverage);

    // run the karma test
    const server = new karma.Server({
        configFile: files.karmaConf,
        singleRun: false
    }, callback);
    server.start();
});
