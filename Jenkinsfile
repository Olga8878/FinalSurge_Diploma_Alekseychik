pipeline {
    agent any

    parameters {
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'master', name: 'BRANCH', type: 'PT_BRANCH'
        choice(name: 'BROWSER', choices: ['chrome', 'firefox', 'safari'], description: 'Select a browser')
        booleanParam(name: 'IS_HEADLESS', defaultValue: false, description: 'Toggle headless mode')
        choice(name: 'SUITE', choices: ['smoke', 'regression', 'all'], description: 'Choose a suite')
    }

    triggers {
            parameterizedCron('''
            0 9 * * 1,3,5 %SUITE=smoke;%BROWSER=chrome;%IS_HEADLESS=false
            00 23 1-31/2 * * %SUITE=regression;%BROWSER=firefox;%IS_HEADLESS=false;
            0 9 * * 1,3,5 %SUITE=smoke;%BROWSER=chrome;%IS_HEADLESS=false
            ''')
        }

    tools {
        maven "m3"
    }

    stages {
        stage('Run tests') {
            steps {
            git branch: "${params.BRANCH}", url: 'https://github.com/Olga8878/FinalSurge_Diploma_Alekseychik.git'
            bat "mvn -Dmaven.test.failure.ignore=true -Dbrowser=${params.BROWSER} -Dheadless=${params.IS_HEADLESS} -DsuiteName=${params.SUITE} clean test"
            }

            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }

        stage('Generate Allure report') {
            steps {
                allure includeProperties: false, report: 'target/allure-report', results: [[path: 'target/allure-results']]
            }
        }
    }
}