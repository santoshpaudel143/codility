package codility.assessment.scrubmember;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ScrubMember {


    public static List<String> scrub(File memberFile) {
        List<String> scrubbedMembers;
        List<Member> membersFromFile = importMembers(memberFile);
        List<Member> nonDuplicateMembers = removeDuplicateMembers(membersFromFile);
        scrubMembersName(nonDuplicateMembers);
        scrubbedMembers = convertMembersToFormattedString(nonDuplicateMembers);
        return scrubbedMembers;
    }

    public static List<Member> importMembers(File inputFile) {
        /*
         * Implement the missing logic
         */
        List<Member> memberList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty() || !line.contains(",")) {
                    continue;
                }
                String[] part = line.split(",");
                if (part.length >= 7) {
                    Member member = new Member();
                    member.setId(part[0].trim());
                    member.setLastName(part[1].trim());
                    member.setFirstName(part[2].trim());
                    member.setAddress(part[3].trim());
                    member.setCity(part[4].trim());
                    member.setState(part[5].trim());
                    member.setZip(part[6].trim());
                    memberList.add(member);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return memberList;
    }

    /**
     * Remove duplicate members
     * Remove if ID is same
     * Remove if combination of firstname,lastname and state is same
     */
    private static List<Member> removeDuplicateMembers(List<Member> membersFromFile) {
        Set<String> seenId = new HashSet<>();
        Set<String> seenCombo = new HashSet<>();

        return membersFromFile.stream().filter(m -> {
            boolean idNotSeen = seenId.add(m.getId());
            String combo = m.getFirstName().trim() + "|" + m.getLastName().trim() + "|" + m.getState().trim();
            boolean comboNotSeen = seenCombo.add(combo);
            return idNotSeen && comboNotSeen;
        }).collect(Collectors.toList());
    }

    /**
     * convert member object to formatted output layout.
     */
    private static List<String> convertMembersToFormattedString(List<Member> nonDuplicateMembers) {
        List<String> formattedString = new ArrayList<>();
        for (Member member : nonDuplicateMembers) {
            formattedString.add(member.toFinalFormatString());
        }
        return formattedString;
    }

    /**
     * set full name from first and last name.
     */
    private static void scrubMembersName(List<Member> nonDuplicateMembers) {
        for (Member member : nonDuplicateMembers) {
            member.setFullName(member.getFirstName() + " " + member.getLastName());
        }
    }

    public static void main(String[] args) throws URISyntaxException {
//        InputStream inputStream = ScrubMember.class.getResourceAsStream("TestDataset.txt");
        URL resourceUrl = ScrubMember.class.getResource("MemberDataset.txt");
        List<String> scrub = scrub(new File(resourceUrl.toURI()));
    }
}