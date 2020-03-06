package com.ecart.jpa.controller;
/*package com.example.jpa.controller;

import com.example.jpa.exception.ResourceNotFoundException;
import com.example.jpa.model.PurchaseHistory;
import com.example.jpa.repository.BuyerRepository;
import com.example.jpa.repository.PurchaseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PurchaseController {

    @Autowired
    private PurchaseRepository commentRepository;

    @Autowired
    private BuyerRepository postRepository;

    @GetMapping("/posts/{postId}/cart")
    public Page<PurchaseHistory> getAllCartByPostId(@PathVariable (value = "postId") Long postId,
                                                Pageable pageable) {
        return commentRepository.findByPostId(postId, pageable);
    }

    @PostMapping("/posts/{postId}/cart")
    public PurchaseHistory createCart(@PathVariable (value = "postId") Long postId,
                                 @Valid @RequestBody PurchaseHistory comment) {
        return postRepository.findById(postId).map(post -> {
            comment.setPost(post);
            return commentRepository.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }

    @PutMapping("/posts/{postId}/cart/{cartId}")
    public PurchaseHistory updateCart(@PathVariable (value = "cartId") Long cartId,
                                 @PathVariable (value = "cartId") Long commentId,
                                 @Valid @RequestBody PurchaseHistory commentRequest) {
        if(!postRepository.existsById(cartId)) {
            throw new ResourceNotFoundException("CartId " + cartId + " not found");
        }

        return commentRepository.findById(commentId).map(comment -> {
            comment.setBuyerId(commentRequest.getBuyerId());
            comment.setSellerId(commentRequest.getSellerId());
            comment.setTransactionId(commentRequest.getTransactionId());
            comment.setItemId(commentRequest.getItemId());
            return commentRepository.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException("CommentId " + commentId + "not found"));
    }

    @DeleteMapping("/posts/{postId}/cart/{cartId}")
    public ResponseEntity<?> deleteComment(@PathVariable (value = "cartId") Long cartId,
                              @PathVariable (value = "cartId") Long commentId) {
        return commentRepository.findByIdAndPostId(commentId, cartId).map(comment -> {
            commentRepository.delete(comment);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Comment not found with id " + commentId + " and postId " + cartId));
    }
}
*/