package nnRelations;

import entities.Group;
import entities.Module;
import entities.Teacher;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class ModuleTeacher {

    private Module module;
    private Teacher teacher;
    private int moduleId;
    private int teacherId;

    public ModuleTeacher(Module module, Teacher teacher) {
        this.module = module;
        this.teacher = teacher;
    }

    public ModuleTeacher(int moduleId, int teacherId) {
        this.moduleId = moduleId;
        this.teacherId = teacherId;
    }

    ArrayList<ModuleTeacher> moduleTeacherLst = new ArrayList<>();
    public void addModuleTeacher(int moduleId, int teacherId) {
        ModuleTeacher moduleTeacher = new ModuleTeacher(moduleId,teacherId);
        moduleTeacherLst.add(moduleTeacher);
    }

    public void addModuleTeacher(Module module, Teacher teacher) {
        ModuleTeacher moduleTeacher = new ModuleTeacher(module,teacher);
        moduleTeacherLst.add(moduleTeacher);
    }

    public void removeModuleTeacher(ModuleTeacher moduleTeacher) {
        int i = 0;
        while (i < moduleTeacherLst.size()) {
            if (moduleTeacherLst.get(i).equals(moduleTeacher) == false) {
                System.out.println("the teacher " + moduleTeacher.teacher + " and the module " + moduleTeacher.module + "  do not exist");
                i++;
            }
            moduleTeacherLst.get(i).removeModuleTeacher(moduleTeacher);

        }

    }

    public void update(ModuleTeacher moduleTeacherOld,ModuleTeacher moduleTeacherNew){
        int i = 0;
        while (i < moduleTeacherLst.size()) {
            if (moduleTeacherLst.get(i).equals(moduleTeacherOld) == false) {

                System.out.println("the teacher " + moduleTeacherOld.teacher + " and the module " + moduleTeacherOld.module +  "  do not exist");
                i++;
            }
            moduleTeacherLst.set(i,moduleTeacherNew);
            System.out.println("the update has been done successfully");

        }
    }

    public void getAll(){
        for (ModuleTeacher x : moduleTeacherLst) {
            System.out.println(x);
        }
    }

    public void getModuleTeacher(int moduleId, int teacherId) {
        int i = 0;
        while (i < moduleTeacherLst.size()) {
            if (((moduleTeacherLst.get(i).module.getId() != moduleId) && (moduleTeacherLst.get(i).teacher.getId() != teacherId)) ) {

                System.out.println("the teacher " + moduleTeacherLst.get(i).teacher + " and the module " + moduleTeacherLst.get(i).module +  "  do not exist");
                i++;
            }
            System.out.println("{ module: "+moduleTeacherLst.get(i).module+ ", teacher: "+moduleTeacherLst.get(i).teacher +" }");

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
