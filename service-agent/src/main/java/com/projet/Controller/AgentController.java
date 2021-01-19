package com.projet.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projet.Repository.AgentRepository;
import com.projet.models.Agent;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class AgentController {

	@Autowired
	private AgentRepository agentRepository;

	@GetMapping("/agents")
	public List<Agent> getAllAgents() {
		return agentRepository.findAll();
	}

	@GetMapping("/agents/{id}")
	public ResponseEntity<Agent> getAgentById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
		Agent agent = agentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No agent with a such id" + id));
		return ResponseEntity.ok().body(agent);
	}

	@PostMapping("/agents")
	public Agent createAgent(@RequestBody Agent agent) {
		return agentRepository.save(agent);
	}

	@PutMapping("/agents/{id}")
	public ResponseEntity<Agent> updateAgent(@PathVariable(value = "id") Integer id,
			@Valid @RequestBody Agent agentDetails) throws ResourceNotFoundException {
		Agent agent = agentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No agent for this id" + id));

		agent.setName(agentDetails.getName());
		agent.setJob(agentDetails.getJob());
		agent.setLastname(agentDetails.getLastname());
		final Agent updatedAgent = agentRepository.save(agent);
		return ResponseEntity.ok(updatedAgent);
	}

	@DeleteMapping("/agents/{id}")
	public Map<String, Boolean> deleteAgent(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
		Agent agent = agentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No agent for this id" + id));

		agentRepository.delete(agent);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
