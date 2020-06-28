package org.wcci.blog;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.blog.entities.Author;
import org.wcci.blog.entities.Category;
import org.wcci.blog.entities.Post;
import org.wcci.blog.entities.Tag;
import org.wcci.blog.repositories.AuthorRepository;
import org.wcci.blog.repositories.CategoryRepository;
import org.wcci.blog.repositories.PostRepository;
import org.wcci.blog.repositories.TagRepository;
import java.time.LocalDate;


@Component
public class Populator implements CommandLineRunner {

    @Autowired
    PostRepository postRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    TagRepository tagRepository;

    @Override
    public void run(String... args) throws Exception {

        Author jimRoss = new Author("Jim Ross");
        Author garretKim = new Author("Garret Kim");
        Author davidSmith = new Author("David Smith");

        authorRepository.save(jimRoss);
        authorRepository.save(garretKim);
        authorRepository.save(davidSmith);

        LocalDate publishDate1 = LocalDate.of(2020,6,15);
        LocalDate publishDate2 = LocalDate.of(2020,6,25);
        LocalDate publishDate3 = LocalDate.of(2020,6,9);


        Category fighter = new Category("Fighter");
        Category fights = new Category("Fights");

        categoryRepository.save(fighter);
        categoryRepository.save(fights);

        Tag fightSkill = new Tag("Fight Skill");
        Tag knockouts = new Tag("Knockouts");
        Tag events = new Tag("Events");

        tagRepository.save(fightSkill);
        tagRepository.save(knockouts);
        tagRepository.save(events);

        Post justIzzy = new Post("Just Izzy", "Since his early MMA fighting days Israel Adesanya was recognized as a star on the rise or at least one to watch.\n" +
                "                     Today we can say that has come to pass three times over. Reigning champion and looking to rise beyond the\n" +
                "                     highlights of the UFC.\n" +
                "                     He has somehow stayed himself despite being touted as one of the more arrogant or cocky fighters of the past\n" +
                "                     decade. An avid anime fan and dubbed the Last Stylebender. Israel Adesanya has a way of fighting all his own.\n" +
                "                     The Nigerian born Kiwi strikes with a percision and ferocity unlike any other. His lengthy build distracts\n" +
                "                     his opponents from his power, an attribute that lends itself well to the knockout artist.\n" +
                "                     Come Saturday, the procession heads into Madison Square Garden, where he'll take on fellow middleweight\n" +
                "                     Derek Brunson at UFC 230. But he won't be a tourist there. He'll be The Last Stylebender, and you'll be\n" +
                "                     the one who needs a camera. The undefeated striking virtuoso has amassed 12 MMA knockouts and a massive\n" +
                "                     cult following. With a big win Saturday, that following could spill into the mainstream.", jimRoss, publishDate1, fighter, fightSkill);

        Post octagonQuarantine = new Post("Octagon Quarantine", "Covid-19 has affected too much of our everyday culture. So much so that the world will never be the same.\n" +
                "The UFC is not excluded from the effects of this outrageous disease. Earlier this month UFC Fight Night 117\n" +
                "and UFC 250 took place.\n" +
                "With many intersesting fights including skillfull submissions or technical striking. The recent UFC bouts\n" +
                "have not disappointed but something quite obvious is missing. The crowd aspect is completely gone and\n" +
                "fights that used to feel like grand stages for gladiators now feel closer to evening sparring at the gym.\n" +
                "Not to say that competition is bad, but the vibrance and grandeur is missing. We are still fortunate to have\n" +
                "quality commentary to compliment the fights which neither need go overlooked.\n" +
                "So what is next for the UFC? Or live sports in general? Hopefully the world can get through this pandemic\n" +
                "and some live event normalcy will return, tough to say when or if that will be. Elevation and fighter\n" +
                "grooming seem to go hand in hand with this MMA juggernaut, so it will come of no surprise when new greats\n" +
                "rise.", garretKim,publishDate2, fights, events);

        Post gloryDays = new Post("Glory Days","The early days of UFC were filled with some of the most brutal KO's of and fights of any combat sport.\n" +
                "One to note is that of Mark \"the Hammer\" Coleman being knocked-out with a kick to the face\n" +
                "by Petey Williams.\n" +
                "That KO sticks out because it was before the UFC banned strikes by foot while fighters wore shoes.\n" +
                "Back in those days steroid regulation was shaky to put it plainly, so the overall brutality\n" +
                "was insane.\n" +
                "Dan Henderson's glorious KO of Michael Bisping is another standout. The on-going feud between the two\n" +
                "made that fight a million times more intense than it could have been. Bisping's trash talk sent Dan\n" +
                "Henderson into a rage which ended up back firing as Bisping went completely stiff from an absolute bomb\n" +
                "of a right hand.",davidSmith, publishDate3, fights, knockouts);

        postRepository.save(justIzzy);
        postRepository.save(octagonQuarantine);
        postRepository.save(gloryDays);
    }
}
