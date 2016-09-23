package com.kidz.modal.pojo;

import java.io.Serializable;

public class VideoList implements Serializable
{
    private String min_age;

    private String desc;

    private String status;

    private String[] tag;

    private String theme;

    private String sub_theme;

    private String max_age;

    private String url;

    private String id;

    private String pub_on_mon;

    private String category;

    private String title;

    private String num_views;

    private String length;

    private String[] language;

    private String rating;

    private String channel;

    private String pub_on_date;

    private String[] dev_area;

    public String getMin_age ()
    {
        return min_age;
    }

    public void setMin_age (String min_age)
    {
        this.min_age = min_age;
    }

    public String getDesc ()
    {
        return desc;
    }

    public void setDesc (String desc)
    {
        this.desc = desc;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public String[] getTag ()
    {
        return tag;
    }

    public void setTag (String[] tag)
    {
        this.tag = tag;
    }

    public String getTheme ()
    {
        return theme;
    }

    public void setTheme (String theme)
    {
        this.theme = theme;
    }

    public String getSub_theme ()
    {
        return sub_theme;
    }

    public void setSub_theme (String sub_theme)
    {
        this.sub_theme = sub_theme;
    }

    public String getMax_age ()
    {
        return max_age;
    }

    public void setMax_age (String max_age)
    {
        this.max_age = max_age;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getPub_on_mon ()
    {
        return pub_on_mon;
    }

    public void setPub_on_mon (String pub_on_mon)
    {
        this.pub_on_mon = pub_on_mon;
    }

    public String getCategory ()
    {
        return category;
    }

    public void setCategory (String category)
    {
        this.category = category;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getNum_views ()
    {
        return num_views;
    }

    public void setNum_views (String num_views)
    {
        this.num_views = num_views;
    }

    public String getLength ()
    {
        return length;
    }

    public void setLength (String length)
    {
        this.length = length;
    }

    public String[] getLanguage ()
    {
        return language;
    }

    public void setLanguage (String[] language)
    {
        this.language = language;
    }

    public String getRating ()
    {
        return rating;
    }

    public void setRating (String rating)
    {
        this.rating = rating;
    }

    public String getChannel ()
    {
        return channel;
    }

    public void setChannel (String channel)
    {
        this.channel = channel;
    }

    public String getPub_on_date ()
    {
        return pub_on_date;
    }

    public void setPub_on_date (String pub_on_date)
    {
        this.pub_on_date = pub_on_date;
    }

    public String[] getDev_area ()
    {
        return dev_area;
    }

    public void setDev_area (String[] dev_area)
    {
        this.dev_area = dev_area;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [min_age = "+min_age+", desc = "+desc+", status = "+status+", tag = "+tag+", theme = "+theme+", sub_theme = "+sub_theme+", max_age = "+max_age+", url = "+url+", id = "+id+", pub_on_mon = "+pub_on_mon+", category = "+category+", title = "+title+", num_views = "+num_views+", length = "+length+", language = "+language+", rating = "+rating+", channel = "+channel+", pub_on_date = "+pub_on_date+", dev_area = "+dev_area+"]";
    }
}