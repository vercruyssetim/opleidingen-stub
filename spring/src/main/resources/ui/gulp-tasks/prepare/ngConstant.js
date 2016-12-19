import gulp from "gulp";
import gulpNgConstant from "gulp-ng-constant";
import {dirs, paths, files} from "../config";
import {argv} from "../argv";

const env = (argv.env) ? argv.env : 'LOCAL';

export const ngConstant = 'ngConstant';
const ENVS = {
    LOCAL: {
        endpoint: '/rest',
        defaultRestTimeoutInMillis: 100000
    }
};

gulp.task(ngConstant, () => {
    gulp.src(`${dirs.gulpTasks}/prepare/config.json`)
        .pipe(gulpNgConstant({
            name: 'mentor.config',
            deps: [],
            constants: {ENV: ENVS[env]},
            wrap: false
        }))
        .pipe(gulp.dest(paths.ngConstant));
});

