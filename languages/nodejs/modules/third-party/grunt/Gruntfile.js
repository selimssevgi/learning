
module.exports = function (grunt) {

  // configuration
  grunt.initConfig({
    concat: {
      js: {
        src: ['js/*.js'],
        dest: 'build/scripts.js'
      },

      css: {
        // src: ['css/*.css'], : file are concat in alphabetical order
        src: ['css/reset.css', 'css/bootstrap.css'], // special order
        dest: 'build/styles.css',
      }
    },

    uglify: {
     build: {
      files: [{
        src: 'build/scripts.js',
        dest: 'build/scripts-uglified.js'
      }]
     }
    }

  });

  // load plugins
  grunt.loadNpmTasks('grunt-contrib-concat');
  grunt.loadNpmTasks('grunt-contrib-uglify');

  // register tasks
  grunt.registerTask('concat-js', ['concat:js']);
  grunt.registerTask('concat-css', ['concat:css']);

  grunt.registerTask('run', function () {
    console.log('I am running!');
  });

  // run task: grunt sleep
  grunt.registerTask('sleep', function () {
    console.log('I am sleeping');
  });

  grunt.registerTask('all', ['sleep', 'run']);

};
