package models;

import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

@Data
public class Comment {
    private UUID comment_id;
    private UUID post_id;
    private String name;
    private String content;
    private UUID user_id;
    private String time_stamp;

    public Comment(UUID comment_id, UUID post_id, String name, String content, UUID user_id, String time_stamp) {
        this.comment_id = comment_id;
        this.post_id = post_id;
        this.name = name;
        this.content = content;
        this.user_id = user_id;
        this.time_stamp = time_stamp;
    }

    public UUID getCommentId() {return this.comment_id;}

    public String getTimeStamp() throws ParseException {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(this.time_stamp);
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss z");
        String dateStr = sdfDate.format(date);
        String timeStr = sdfTime.format(date);
        return "on " + dateStr + " at " + timeStr;
    }
}
