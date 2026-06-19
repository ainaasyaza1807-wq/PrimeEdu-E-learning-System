package entity;

public class ContentFactory {

    public static LearningContent
    createContent(
            String type,
            int id,
            String title,
            String description) {

        if(type.equalsIgnoreCase(
                "MATERIAL")){

            return new Material(
                    id,
                    title,
                    description,
                    ""
            );
        }

        if(type.equalsIgnoreCase(
                "ASSESSMENT")){

            return new AssessmentMaterial(
                    id,
                    title,
                    description,
                    100
            );
        }

        return null;
    }
}