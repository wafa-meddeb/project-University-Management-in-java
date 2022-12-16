package nnRelations;

import entities.Group;
import entities.Module;
import lombok.*;

import java.util.*;

@NoArgsConstructor
@ToString
@Getter
@Setter


public class ModuleGroup {
    private Module module;
    private Group group;

    private int moduleId;
    private int groupId;
    private int year;

    public ModuleGroup(Module module, Group group, int year) {
        this.module = module;
        this.group = group;
        this.year = year;
    }
    public ModuleGroup(int moduleId, int groupId, int year) {
        this.moduleId = moduleId;
        this.groupId = groupId;
        this.year = year;
    }

    ArrayList<ModuleGroup> moduleGrpLst = new ArrayList<>();
    public void addModuleGrp(int moduleId, int groupId, int year) {
        ModuleGroup moduleGrp = new ModuleGroup(moduleId, groupId, year);
        moduleGrpLst.add(moduleGrp);
    }

    public void addModuleGrp(Module module, Group group, int year) {
        ModuleGroup moduleGrp = new ModuleGroup(module, group, year);
        moduleGrpLst.add(moduleGrp);
    }

    public void removeModuleGrp(ModuleGroup moduleGrp) {
        int i = 0;
        while (i < moduleGrpLst.size()) {
            if (moduleGrpLst.get(i).equals(moduleGrp) == false) {
                System.out.println("the group " + moduleGrp.group + " and the module " + moduleGrp.module + "of year " + moduleGrp.year + "  do not exist");
                i++;
            }
            moduleGrpLst.get(i).removeModuleGrp(moduleGrp);

        }

    }

    public void update(ModuleGroup moduleGrpOld,ModuleGroup moduleGrpNew){
        int i = 0;
        while (i < moduleGrpLst.size()) {
            if (moduleGrpLst.get(i).equals(moduleGrpOld) == false) {

                System.out.println("the group " + moduleGrpOld.group + " and the module " + moduleGrpOld.module + "of year " + moduleGrpOld.year + "  do not exist");
                i++;
            }
            moduleGrpLst.set(i,moduleGrpNew);
            System.out.println("the update has been done successfully");

        }
    }

    public void getAll(){
        for (ModuleGroup x : moduleGrpLst) {
            System.out.println(x);
        }
    }

    public void getModuleGrp(int moduleId, int grpId, int year) {
        int i = 0;
        while (i < moduleGrpLst.size()) {
            if (((moduleGrpLst.get(i).module.getId() != moduleId) && (moduleGrpLst.get(i).group.getId() != grpId)) && (moduleGrpLst.get(i).year != year)) {

                System.out.println("the group " + moduleGrpLst.get(i).group + " and the module " + moduleGrpLst.get(i).module + "of year " + moduleGrpLst.get(i).year + "  do not exist");
                i++;
            }
            System.out.println("{ module: "+moduleGrpLst.get(i).module+ ", group: "+moduleGrpLst.get(i).group+" year: "+moduleGrpLst.get(i).year+" }");

        }

    }



}
