package uz.itschool.marks.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.itschool.marks.database.dao.*
import uz.itschool.marks.database.entity.*

@Database(entities = [Group::class, Mark::class, Student::class, Subject::class, Teacher::class, TeacherGroupSubject::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun getGroupDao(): GroupDao
    abstract fun getMarkDao(): MarkDao
    abstract fun getStudentDao(): StudentDao
    abstract fun getSubjectDao(): SubjectDao
    abstract fun getTeacherDao(): TeacherDao
    abstract fun getTeacherGroupSubjectDao(): TeacherGroupSubjectDao

    companion object {
        private var instance: AppDataBase? = null
        fun getInstance(context: Context): AppDataBase {
            if (instance == null) {
                instance = Room.databaseBuilder(context, AppDataBase::class.java, "app_db")
                    .allowMainThreadQueries().build()
                if (instance!!.getStudentDao().getStudents().isEmpty()){
                    initDB()
                }
            }
            return instance!!
        }

        private fun initDB() {
            instance!!.getGroupDao().addGroup(Group(name = "10-05"))
            instance!!.getGroupDao().addGroup(Group(name = "10-04"))
            instance!!.getGroupDao().addGroup(Group(name = "10-03"))

            instance!!.getSubjectDao().addSubject(Subject(name = "Matematika"))
            instance!!.getSubjectDao().addSubject(Subject(name = "Fizika"))
            instance!!.getSubjectDao().addSubject(Subject(name = "Informatika"))

            instance!!.getTeacherDao().addTeacher(Teacher(login = "akobir_0", password = "akobir_0", firstName = "Akobir", lastName =  "Kilichov", subjectId = 1))
            instance!!.getTeacherDao().addTeacher(Teacher(login = "bekmurod_1", password = "bekmurod_1", firstName = "Bekmurod", lastName =  "Qutlimurodov", subjectId = 2))
            instance!!.getTeacherDao().addTeacher(Teacher(login = "mirjambil_2", password = "mirjambil_2", firstName = "Mirjambil", lastName =  "Mirg'iyozov", subjectId = 3))

            instance!!.getTeacherGroupSubjectDao().addTeacherGroupSubject(TeacherGroupSubject(teacherId = 1, groupId = 1, subjectId = 1))
            instance!!.getTeacherGroupSubjectDao().addTeacherGroupSubject(TeacherGroupSubject(teacherId = 1, groupId = 2, subjectId = 1))
            instance!!.getTeacherGroupSubjectDao().addTeacherGroupSubject(TeacherGroupSubject(teacherId = 2, groupId = 2, subjectId = 2))
            instance!!.getTeacherGroupSubjectDao().addTeacherGroupSubject(TeacherGroupSubject(teacherId = 2, groupId = 3, subjectId = 2))
            instance!!.getTeacherGroupSubjectDao().addTeacherGroupSubject(TeacherGroupSubject(teacherId = 3, groupId = 1, subjectId = 3))
            instance!!.getTeacherGroupSubjectDao().addTeacherGroupSubject(TeacherGroupSubject(teacherId = 3, groupId = 3, subjectId = 3))

            instance!!.getStudentDao().addStudent(Student(login = "10050", password = "Ab.10050", firstName = "Bekzod", lastName = "Muxtorxonov", group_id = 1))
            instance!!.getStudentDao().addStudent(Student(login = "10051", password = "Ab.10051", firstName = "Abdumajid", lastName = "Adilov", group_id = 1))
            instance!!.getStudentDao().addStudent(Student(login = "10052", password = "Ab.10052", firstName = "Maftuna", lastName = "Mahkamova", group_id = 1))
            instance!!.getStudentDao().addStudent(Student(login = "10053", password = "Ab.10053", firstName = "Aziz", lastName = "Raimov", group_id = 1))
            instance!!.getStudentDao().addStudent(Student(login = "10040", password = "Ab.10040", firstName = "Sattor", lastName = "Xamroyev", group_id = 2))
            instance!!.getStudentDao().addStudent(Student(login = "10041", password = "Ab.10041", firstName = "Qayumov", lastName = "Asilbek", group_id = 2))
            instance!!.getStudentDao().addStudent(Student(login = "10042", password = "Ab.10042", firstName = "Shuxrat", lastName = "Komilov", group_id = 2))
            instance!!.getStudentDao().addStudent(Student(login = "10043", password = "Ab.10043", firstName = "Ibrohim", lastName = "Mirzayev", group_id = 2))
            instance!!.getStudentDao().addStudent(Student(login = "s9", password = "1234", firstName = "Student9", lastName = "Aliyev", group_id = 3))
            instance!!.getStudentDao().addStudent(Student(login = "s10", password = "1234", firstName = "Student10", lastName = "Aliyev", group_id = 3))
            instance!!.getStudentDao().addStudent(Student(login = "s11", password = "1234", firstName = "Student11", lastName = "Aliyev", group_id = 3))
            instance!!.getStudentDao().addStudent(Student(login = "s12", password = "1234", firstName = "Student12", lastName = "Aliyev", group_id = 3))

            ///////////////////////////////////////////////////////////////////////////////////////

            instance!!.getMarkDao().addMark(Mark(mark = 5, teacherGroupSubject = 1, studentId = 1))
            instance!!.getMarkDao().addMark(Mark(mark = 5, teacherGroupSubject = 1, studentId = 1))
            instance!!.getMarkDao().addMark(Mark(mark = 5, teacherGroupSubject = 1, studentId = 1))
            instance!!.getMarkDao().addMark(Mark(mark = 4, teacherGroupSubject = 1, studentId = 1))
            instance!!.getMarkDao().addMark(Mark(mark = 4, teacherGroupSubject = 1, studentId = 1))
            instance!!.getMarkDao().addMark(Mark(mark = 4, teacherGroupSubject = 5, studentId = 1))
            instance!!.getMarkDao().addMark(Mark(mark = 4, teacherGroupSubject = 5, studentId = 1))
            instance!!.getMarkDao().addMark(Mark(mark = 5, teacherGroupSubject = 5, studentId = 1))


            instance!!.getMarkDao().addMark(Mark(mark = 5, teacherGroupSubject = 2, studentId = 5))
            instance!!.getMarkDao().addMark(Mark(mark = 4, teacherGroupSubject = 2, studentId = 5))
            instance!!.getMarkDao().addMark(Mark(mark = 5, teacherGroupSubject = 2, studentId = 5))
            instance!!.getMarkDao().addMark(Mark(mark = 3, teacherGroupSubject = 2, studentId = 5))
            instance!!.getMarkDao().addMark(Mark(mark = 5, teacherGroupSubject = 2, studentId = 5))
            instance!!.getMarkDao().addMark(Mark(mark = 5, teacherGroupSubject = 3, studentId = 5))
            instance!!.getMarkDao().addMark(Mark(mark = 5, teacherGroupSubject = 3, studentId = 5))
            instance!!.getMarkDao().addMark(Mark(mark = 4, teacherGroupSubject = 3, studentId = 5))
            instance!!.getMarkDao().addMark(Mark(mark = 5, teacherGroupSubject = 3, studentId = 5))
            instance!!.getMarkDao().addMark(Mark(mark = 3, teacherGroupSubject = 3, studentId = 5))
            instance!!.getMarkDao().addMark(Mark(mark = 5, teacherGroupSubject = 3, studentId = 5))
            instance!!.getMarkDao().addMark(Mark(mark = 5, teacherGroupSubject = 3, studentId = 5))
        }
    }
}