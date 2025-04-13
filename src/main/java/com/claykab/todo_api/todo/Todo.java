package com.claykab.todo_api.todo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.time.LocalDate;  
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter; 

@Entity
@Table(name = "todo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Todo {
    @Id
    @SequenceGenerator(name = "todo_seq", initialValue = 1110, allocationSize = 101)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "todo_seq")
    @Column(name = "todo_item_id", updatable = false, nullable = false)
    private long todoId;

    @NotBlank
    @Size(min = 5, message = "A Title should have at least 5 characters")
    @Column(name = "todo_title")
    private String todoTitle;

    @NotBlank
    @Size(min = 5, message = "A Description should have at least 5 characters")
    @Column(name = "todo_description")
    private String todoDescription;

    @Column(name = "is_complete")
    private boolean isComplete;

    @FutureOrPresent(message = "The date must be in the present or future")
    @Column(name = "todo_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") // Ensure this pattern matches your input format
    private LocalDate todoDate;

    @Column(name = "creation_date", updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss") // Fixed format for LocalDateTime
    @CreationTimestamp
    private LocalDateTime creationDate;

    @Column(name = "update_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss") // Fixed format for LocalDateTime
    @UpdateTimestamp
    private LocalDateTime updateDate;

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public long getTodoId() {
        return todoId;
    }

    public void setTodoId(long todoId) {
        todoId = todoId;
    }

    public String getTodoTitle() {
        return todoTitle;
    }

    public void setTodoTitle(String todoTitle) {
        this.todoTitle = todoTitle;
    }

    public String getTodoDescription() {
        return todoDescription;
    }

    public void setTodoDescription(String todoDescription) {
        this.todoDescription = todoDescription;
    }

    public @FutureOrPresent LocalDate getTodoDate() {
        return todoDate;
    }

    public void setTodoDate(@FutureOrPresent LocalDate todoDate) {
        this.todoDate = todoDate;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}
