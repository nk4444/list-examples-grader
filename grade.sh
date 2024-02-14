CPATH='.:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar'

rm -rf student-submission
rm -rf grading-area

mkdir grading-area

git clone $1 student-submission
echo 'Finished cloning'

if [ ! -f student-submission/ListExamples.java ]
then
    echo "Incorrect file submitted"
    echo "Score: 0"
    exit 
fi

# Draw a picture/take notes on the directory structure that's set up after
# getting to this point
cp student-submission/ListExamples.java grading-area
cp -r lib grading-area
cp TestListExamples.java grading-area
cp Server.java grading-area
cp GradeServer.java grading-area

cd grading-area

# Then, add here code to compile and run, and do any post-processing of the
# tests
set +e
javac -cp $CPATH *.java 
java -cp $CPATH org.junit.runner.JUnitCore TestListExamples 