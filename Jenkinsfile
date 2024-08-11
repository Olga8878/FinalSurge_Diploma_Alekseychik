pipeline {
    agent any
    triggers {
        parameterizedCron('''
            0 9 * * 1,3,5 %SUITE=smoke;%BROWSER=chrome;%IS_HEADLESS=false
            00 23 1-31/2 * * %SUITE=regression;%BROWSER=firefox;%IS_HEADLESS=false;
            0 8 * * 2,3,4 %SUITE=all;%BROWSER=chrome;%IS_HEADLESS=false
        ''')
    }
    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "m3"
    }

    parameters {
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'aster', name: 'BRANCH', type: 'PT_BRANCH'
        choice(name: 'SUITE_NAME', choices: ['smoke.xml','regression.xml', 'all.xml'], description: 'Choice suiteXmlFile')
        choice(name: 'BROWSER', choices: ['chrome', 'firefox', 'edge'], description: 'Select a browser')
    }

    stages {
        stage('Run tests') {
            steps {
                // Get some code from a GitHub repository
                git branch: "${params.BRANCH}", url: 'https://github.com/Olga8878/FinalSurge_Diploma_Alekseychik.git'

                // Run Maven on a Unix agent.
                bat "mvn -Dmaven.test.failure.ignore=true -DsuiteXmlFile=${params.SUITE_NAME} -Dbrowser=${params.BROWSER} clean test"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
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