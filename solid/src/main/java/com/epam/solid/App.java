package com.epam.solid;

import java.io.File;
/**
 * Single Responsibility
 *
 */
import java.util.*;
import java.util.logging.Logger;
public class App
{
    private ErrorLogger errorLogger = new ErrorLogger();

    void CreatePost(Database db, String postMessage)
    {
        try
        {
            db.Add(postMessage);
        }
        catch (Exception ex)
        {
            errorLogger.log(ex.toString());
        }
    }
}

class ErrorLogger
{
    void log(String error)
    {
      Object db;
      
	((Object) db).LogError("An error occured: ", error);
      File.WriteAllText("ram.txt", error);
    }
}
//Open/closed principle by inhertitance
class Post
{
    void CreatePost(Database db, String postMessage)
    {
        db.Add(postMessage);
    }
}

class TagPost extends Post
{
    void CreatePost(Database db, String postMessage)
    {
        db.AddAsTag(postMessage);
    }
}
//Liskov Substitution principle


class MentionPost extends Post
{
    void CreatePost(Database db, String postMessage)
    {
        String user = postMessage.parseUser(user);

        NotifyUser(user);
        OverrideExistingMention(user, postMessage)
        App base;
		base.CreatePost(db, postMessage);
    }

    private void NotifyUser(String user)
    {
        MentionPost db;
		db.NotifyUser(user);
    }

    private void OverrideExistingMention(String user, String postMessage)
    {
        MentionPost db = null;
		String _user = null;
		db.OverrideExistingMention(_user, postMessage);
    }
}
//Interface Segregation principle
interface IPostCreate
{
    void CreatePost();
}

interface IPostRead
{
    void ReadPost();
}
//Dependency principle
class Postr
{
    private Logger _logger;

    public void Post(Logger injectedLogger)
    {
        _logger = injectedLogger;
    }

    void CreatePost(Database db, String postMessage)
    {
        try
        {
            db.Add(postMessage);
        }
        catch (Exception ex)
        {
            Logger logger = null;
			logger.log(null, ex.toString());
			
        }
    }
}

