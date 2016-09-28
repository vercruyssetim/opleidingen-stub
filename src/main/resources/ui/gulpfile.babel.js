import gulp from 'gulp';
import {prepare, cleanAssets} from './gulp-tasks/prepare/prepare.js';
import './gulp-tasks/test/test.js';
import './gulp-tasks/dev/dev.js';
import {cleanDist} from './gulp-tasks/build/clean.js';
import './gulp-tasks/build/build.js';
import './gulp-tasks/release/rename-appName';

gulp.task('default', [prepare]);

gulp.task('clean', [cleanAssets, cleanDist]);

