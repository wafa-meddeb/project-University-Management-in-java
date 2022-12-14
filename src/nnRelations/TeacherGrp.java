package nnRelations;

import entities.Group;
import entities.Teacher;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
@NoArgsConstructor
@Getter
@Setter
@ToString

public class TeacherGrp {

    private Teacher teacher;
    private Group group;

    public TeacherGrp(Teacher teacher, Group group) {
        this.teacher = teacher;
        this.group = group;

    }
    ArrayList<TeacherGrp> groupTeacherLst = new ArrayList<>();

    public void addGroupTeacher(Group group, Teacher teacher) {
        TeacherGrp teacherGrp = new TeacherGrp(teacher, group);
        groupTeacherLst.add(teacherGrp);
    }

    public void removeGroupTeacher(TeacherGrp groupTeacher) {
        int i = 0;
        while (i < groupTeacherLst.size()) {
            if (groupTeacherLst.get(i).equals(groupTeacher) == false) {
                System.out.println("the teacher " + groupTeacher.teacher + " and the group " + groupTeacher.group + "  do not exist");
                i++;
            }
            groupTeacherLst.get(i).removeGroupTeacher(groupTeacher);

        }

    }

    public void update(TeacherGrp grpTeacherOld, TeacherGrp grpTeacherNew) {
        int i = 0;
        while (i < groupTeacherLst.size()) {
            if (groupTeacherLst.get(i).equals(grpTeacherOld) == false) {

                System.out.println("the teacher " + grpTeacherOld.teacher + " and the group " + grpTeacherOld.group + "  do not exist");
                i++;
            }
            groupTeacherLst.set(i, grpTeacherNew);
            System.out.println("the update has been done successfully");

        }
    }

    public void getAll() {
        for (TeacherGrp x : groupTeacherLst) {
            System.out.println(x);
        }
    }

    public void getGroupTeacher(int groupId, int teacherId) {
        int i = 0;
        while (i < groupTeacherLst.size()) {
            if (((groupTeacherLst.get(i).group.getId() != groupId) && (groupTeacherLst.get(i).teacher.getId() != teacherId))) {

                System.out.println("the teacher " + groupTeacherLst.get(i).teacher + " and the module " + groupTeacherLst.get(i).group + "  do not exist");
                i++;
            }
            System.out.println("{ module: " + groupTeacherLst.get(i).group + ", teacher: " + groupTeacherLst.get(i).teacher + " }");

        }

    }

//    public void getModuleGrpByCriteria(Object obj){
//        for(int i=0 ;i<moduleGrpLst.size();i++){
//
//
//        }
//
//    }
}