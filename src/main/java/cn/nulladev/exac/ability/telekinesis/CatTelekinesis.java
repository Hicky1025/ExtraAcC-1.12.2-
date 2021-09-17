package cn.nulladev.exac.ability.telekinesis;

import cn.academy.ability.Category;
import cn.academy.ability.Skill;
import cn.academy.ability.vanilla.VanillaCategories;
import cn.nulladev.exac.ability.telekinesis.skill.*;

public class CatTelekinesis extends Category {

    public static Skill psycho_throwing = PsychoThrowing.INSTANCE;
    public static Skill psycho_transmission = PsychoTransmission.INSTANCE;

    public static Skill psycho_needling = PsychoNeedling.INSTANCE;
    public static Skill insulation = Insulation.INSTANCE;

    public static Skill overload_thinking = OverloadThinking.INSTANCE;

    public CatTelekinesis() {
        super("telekinesis");
        this.setColorStyle(255, 127, 127, 127);

        addSkill(psycho_throwing);
        addSkill(psycho_transmission);

        addSkill(psycho_needling);
        addSkill(insulation);

        addSkill(overload_thinking);

        VanillaCategories.addGenericSkills(this);

        psycho_throwing.setPosition(20, 25);
        psycho_transmission.setPosition(30, 65);

        psycho_needling.setPosition(70, 20);
        insulation.setPosition(80, 50);

        overload_thinking.setPosition(120, 75);
    }

}
