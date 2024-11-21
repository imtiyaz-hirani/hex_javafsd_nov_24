import { Component, OnDestroy, OnInit } from '@angular/core';
import { PostService } from '../../service/post.service';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-post-list',
  imports: [NgFor],
  templateUrl: './post-list.component.html',
  styleUrl: './post-list.component.css'
})
export class PostListComponent implements OnInit,OnDestroy{

  posts: any[] = [];
  errorMsg: string | undefined;
  constructor(private postService: PostService){ }
  ngOnInit(): void {
    this.postService.getAllPost().subscribe({
      next : (data)=>{
        //console.log(data)
        this.posts = data;
      },
      error: (err)=>{
        this.errorMsg = err.message;
      }
    });
  }

  ngOnDestroy(): void {
    //unsubscribe to all subscriptions
  }
}
