package org.itachi.cloud.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;
import org.itachi.cloud.domain.Item;
import org.itachi.cloud.domain.Saving;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Created by itachi on 2017/9/8.
 * User: itachi
 * Date: 2017/9/8
 * Time: 16:00
 */
@Document(collection = "accounts")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {
    @Id
    private String name;

    private Date lastSeen;

    @Valid
    private List<Item> incomes;

    @Valid
    private List<Item> expenses;

    @Valid
    @NotNull
    private Saving saving;

    @Length(min = 0, max = 20_000)
    private String note;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(Date lastSeen) {
        this.lastSeen = lastSeen;
    }

    public List<Item> getIncomes() {
        return incomes;
    }

    public void setIncomes(List<Item> incomes) {
        this.incomes = incomes;
    }

    public List<Item> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Item> expenses) {
        this.expenses = expenses;
    }

    public Saving getSaving() {
        return saving;
    }

    public void setSaving(Saving saving) {
        this.saving = saving;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
