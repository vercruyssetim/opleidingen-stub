import gulp from "gulp";
import del from "del";
import {fileGroups} from "../config";

export const cleanDist = 'clean:dist';

gulp.task(cleanDist, callback =>
  del(fileGroups.cleanDist, {force:true}, callback));
